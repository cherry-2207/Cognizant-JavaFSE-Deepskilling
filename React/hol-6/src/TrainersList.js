import React from "react";
import { Link } from "react-router-dom";

const TrainersList = ({ trainers }) => {
  return (
    <div style={{ padding: "20px", fontFamily: "sans-serif" }}>
      <h2 style={{ color: "#222" }}>Trainers List</h2>
      <ul style={{ listStyleType: "none", padding: 0 }}>
        {trainers.map((trainer) => (
          <li key={trainer.TrainerId} style={{ margin: "10px 0" }}>
            <Link
              to={`/trainer/${trainer.TrainerId}`}
              style={{
                textDecoration: "none",
                fontSize: "18px",
                color: "#0066cc",
                fontWeight: "500"
              }}
            >
              {trainer.Name}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TrainersList;
