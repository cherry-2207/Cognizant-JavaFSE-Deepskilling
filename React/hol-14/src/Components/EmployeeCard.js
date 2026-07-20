import React, { useContext } from "react";
import ThemeContext from "../ThemeContext";

const EmployeeCard = ({ employee }) => {
  const theme = useContext(ThemeContext);

  const buttonClass = theme === "light" ? "btn-light" : "btn-dark";

  return (
    <div
      style={{
        border: "1px solid #ccc",
        borderRadius: "8px",
        padding: "15px",
        margin: "10px",
        width: "250px",
        backgroundColor: theme === "light" ? "#fff" : "#333",
        color: theme === "light" ? "#000" : "#fff",
        boxShadow: "0 2px 4px rgba(0,0,0,0.1)",
        display: "inline-block",
        verticalAlign: "top",
        fontFamily: "sans-serif"
      }}
    >
      <h3 style={{ margin: "0 0 10px 0" }}>{employee.name}</h3>
      <p style={{ margin: "5px 0" }}><strong>Role:</strong> {employee.role}</p>
      <p style={{ margin: "5px 0" }}><strong>Department:</strong> {employee.dept}</p>
      
      <button className={buttonClass} style={{ marginTop: "10px", padding: "8px 12px", border: "none", borderRadius: "4px", cursor: "pointer", fontWeight: "bold" }}>
        View Details
      </button>
    </div>
  );
};

export default EmployeeCard;
