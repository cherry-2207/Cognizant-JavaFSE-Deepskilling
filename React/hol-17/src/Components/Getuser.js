import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true,
      error: null
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch("https://api.randomuser.me/");
      if (!response.ok) {
        throw new Error("HTTP error! status: " + response.status);
      }
      const data = await response.json();
      
      // The API returns an object with a results array containing user details
      if (data.results && data.results.length > 0) {
        this.setState({
          user: data.results[0],
          loading: false
        });
      } else {
        throw new Error("No user data found in the response.");
      }
    } catch (err) {
      this.setState({
        error: err.message,
        loading: false
      });
    }
  }

  render() {
    const { user, loading, error } = this.state;

    if (loading) {
      return (
        <div style={{ textAlign: "center", padding: "20px", fontFamily: "sans-serif" }}>
          <h3>Loading user details...</h3>
        </div>
      );
    }

    if (error) {
      return (
        <div style={{ textAlign: "center", padding: "20px", fontFamily: "sans-serif", color: "red" }}>
          <h3>Error loading user data: {error}</h3>
        </div>
      );
    }

    if (!user) {
      return null;
    }

    const { name, picture } = user;

    return (
      <div
        style={{
          fontFamily: "sans-serif",
          maxWidth: "350px",
          margin: "20px auto",
          padding: "25px",
          border: "1px solid #ccc",
          borderRadius: "10px",
          textAlign: "center",
          boxShadow: "0 4px 8px rgba(0,0,0,0.1)",
          backgroundColor: "#fff"
        }}
      >
        <h2 style={{ color: "#333", borderBottom: "2px solid #008cba", paddingBottom: "10px", marginTop: 0 }}>
          Random User Profile
        </h2>
        <div style={{ margin: "20px 0" }}>
          <img
            src={picture.large}
            alt={`${name.first} avatar`}
            style={{
              width: "150px",
              height: "150px",
              borderRadius: "50%",
              border: "3px solid #008cba",
              boxShadow: "0 2px 4px rgba(0,0,0,0.15)"
            }}
          />
        </div>
        <div style={{ fontSize: "20px", fontWeight: "bold", color: "#222" }}>
          {name.title}. {name.first}
        </div>
        <div style={{ color: "#666", marginTop: "5px", textTransform: "capitalize" }}>
          {user.location.city}, {user.location.country}
        </div>
      </div>
    );
  }
}

export default Getuser;
