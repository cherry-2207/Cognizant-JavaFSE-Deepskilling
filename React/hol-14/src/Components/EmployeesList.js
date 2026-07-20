import React from "react";
import EmployeeCard from "./EmployeeCard";

const EmployeesList = ({ employees }) => {
  return (
    <div>
      <h3>List of Active Employees</h3>
      <div style={{ display: "flex", flexWrap: "wrap", gap: "10px" }}>
        {employees.map((emp) => (
          <EmployeeCard key={emp.id} employee={emp} />
        ))}
      </div>
    </div>
  );
};

export default EmployeesList;
