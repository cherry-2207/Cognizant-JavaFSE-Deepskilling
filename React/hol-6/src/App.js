import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import TrainersList from "./TrainersList";
import TrainerDetail from "./TrainerDetails";
import { mockTrainers } from "./TrainersMock";
import "./App.css";

function App() {
  return (
    <Router>
      <div style={{ fontFamily: "sans-serif", padding: "10px" }}>
        {/* Navigation Bar */}
        <nav
          style={{
            display: "flex",
            gap: "20px",
            padding: "15px",
            backgroundColor: "#f0f0f0",
            borderBottom: "1px solid #ddd",
            marginBottom: "20px"
          }}
        >
          <Link to="/" style={{ textDecoration: "none", color: "#333", fontWeight: "bold" }}>
            Home
          </Link>
          <Link to="/trainers" style={{ textDecoration: "none", color: "#333", fontWeight: "bold" }}>
            Trainers List
          </Link>
        </nav>

        {/* Routes Mapping */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={mockTrainers} />} />
          <Route path="/trainer/:id" element={<TrainerDetail />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
