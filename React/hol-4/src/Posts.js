import React, { Component } from "react";

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts = () => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        this.setState({ posts: data });
      })
      .catch((error) => {
        this.setState({ error: error.message });
        this.componentDidCatch(error, error.message);
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert(`Error: ${error.message || error}`);
  }

  render() {
    const { posts, error } = this.state;
    if (error) {
      return (
        <div style={{ color: "red", textAlign: "center" }}>
          <h3>An error occurred: {error}</h3>
        </div>
      );
    }
    return (
      <div style={{ padding: "20px", fontFamily: "sans-serif" }}>
        <h2 style={{ textAlign: "center", color: "#333" }}>Posts</h2>
        <div style={{ display: "flex", flexDirection: "column", gap: "15px" }}>
          {posts.map((post) => (
            <div
              key={post.id}
              style={{
                border: "1px solid #ccc",
                borderRadius: "8px",
                padding: "15px",
                backgroundColor: "#f9f9f9"
              }}
            >
              <h3 style={{ margin: "0 0 10px 0", color: "#0066cc" }}>
                {post.title}
              </h3>
              <p style={{ margin: 0, color: "#555" }}>{post.body}</p>
            </div>
          ))}
        </div>
      </div>
    );
  }
}

export default Posts;
