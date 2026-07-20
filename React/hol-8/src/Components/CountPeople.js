import React, { Component } from "react";

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  UpdateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  UpdateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ padding: "30px", fontFamily: "sans-serif", textAlign: "center" }}>
        <h1 style={{ color: "#333" }}>Mall Footfall Counter</h1>
        
        <div style={{ display: "flex", justifyContent: "center", gap: "50px", margin: "30px 0" }}>
          <div style={{ border: "1px solid #ccc", padding: "20px", borderRadius: "8px", minWidth: "150px" }}>
            <h3 style={{ color: "forestgreen", margin: "0 0 10px 0" }}>Total Entered</h3>
            <p style={{ fontSize: "36px", fontWeight: "bold", margin: 0 }}>{this.state.entrycount}</p>
            <button
              onClick={this.UpdateEntry}
              style={{
                marginTop: "15px",
                padding: "8px 16px",
                backgroundColor: "forestgreen",
                color: "#fff",
                border: "none",
                borderRadius: "4px",
                cursor: "pointer",
                fontWeight: "bold"
              }}
            >
              Login (Enter)
            </button>
          </div>

          <div style={{ border: "1px solid #ccc", padding: "20px", borderRadius: "8px", minWidth: "150px" }}>
            <h3 style={{ color: "crimson", margin: "0 0 10px 0" }}>Total Exited</h3>
            <p style={{ fontSize: "36px", fontWeight: "bold", margin: 0 }}>{this.state.exitcount}</p>
            <button
              onClick={this.UpdateExit}
              style={{
                marginTop: "15px",
                padding: "8px 16px",
                backgroundColor: "crimson",
                color: "#fff",
                border: "none",
                borderRadius: "4px",
                cursor: "pointer",
                fontWeight: "bold"
              }}
            >
              Exit
            </button>
          </div>
        </div>
      </div>
    );
  }
}

export default CountPeople;
