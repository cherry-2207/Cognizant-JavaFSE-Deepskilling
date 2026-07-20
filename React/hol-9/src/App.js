import React, { useState } from "react";
import "./App.css";
import ListofPlayers from "./Components/ListofPlayers";
import IndianPlayers from "./Components/IndianPlayers";

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div style={{ padding: "20px", fontFamily: "sans-serif" }}>
      <h1 style={{ color: "#333", borderBottom: "2px solid #ddd", paddingBottom: "10px" }}>
        Cricket App - ES6 Features
      </h1>
      
      <button
        onClick={() => setFlag(!flag)}
        style={{
          padding: "10px 20px",
          fontSize: "16px",
          backgroundColor: flag ? "#0066cc" : "#444",
          color: "#fff",
          border: "none",
          borderRadius: "4px",
          cursor: "pointer",
          fontWeight: "bold",
          marginBottom: "20px"
        }}
      >
        Toggle View (Current: Flag = {flag.toString()})
      </button>

      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
