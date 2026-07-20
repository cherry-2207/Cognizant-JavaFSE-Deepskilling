import React from "react";
import { useParams, Link } from "react-router-dom";
import { mockTrainers } from "./TrainersMock";

const TrainerDetail = () => {
  const { id } = useParams();
  
  // Find trainer by TrainerId (note: params from URL are strings, TrainerId is a number)
  const trainer = mockTrainers.find((t) => t.TrainerId.toString() === id);

  if (!trainer) {
    return (
      <div style={{ padding: "20px", fontFamily: "sans-serif" }}>
        <h2>Trainer Not Found</h2>
        <Link to="/trainers">Back to Trainers List</Link>
      </div>
    );
  }

  return (
    <div style={{ padding: "20px", fontFamily: "sans-serif", maxWidth: "400px" }}>
      <h2 style={{ color: "#222", borderBottom: "1px solid #ccc", paddingBottom: "10px" }}>
        Trainer Details
      </h2>
      <table style={{ width: "100%", borderCollapse: "collapse", margin: "20px 0" }}>
        <tbody>
          <tr>
            <td style={{ fontWeight: "bold", padding: "8px 0" }}>Trainer ID:</td>
            <td>{trainer.TrainerId}</td>
          </tr>
          <tr>
            <td style={{ fontWeight: "bold", padding: "8px 0" }}>Name:</td>
            <td>{trainer.Name}</td>
          </tr>
          <tr>
            <td style={{ fontWeight: "bold", padding: "8px 0" }}>Email:</td>
            <td>{trainer.Email}</td>
          </tr>
          <tr>
            <td style={{ fontWeight: "bold", padding: "8px 0" }}>Phone:</td>
            <td>{trainer.Phone}</td>
          </tr>
          <tr>
            <td style={{ fontWeight: "bold", padding: "8px 0" }}>Technology:</td>
            <td>{trainer.Technology}</td>
          </tr>
          <tr>
            <td style={{ fontWeight: "bold", padding: "8px 0" }}>Skills:</td>
            <td>{trainer.Skills}</td>
          </tr>
        </tbody>
      </table>
      <Link to="/trainers" style={{ color: "#0066cc", textDecoration: "none" }}>
        &larr; Back to Trainers List
      </Link>
    </div>
  );
};

export default TrainerDetail;
