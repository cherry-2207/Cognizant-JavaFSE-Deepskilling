import React from "react";

const CohortDetails = ({ cohort }) => {
  if (!cohort) return null;

  const { code, name, status, startDate, endDate, studentsCount } = cohort;
  
  const h3Style = {
    color: status === "ongoing" ? "green" : "blue"
  };

  return (
    <div className="box" style={{ border: "1px solid black", padding: "10px", margin: "10px", borderRadius: "10px", width: "300px" }}>
      <h3 style={h3Style}>{code}</h3>
      <dl>
        <dt style={{ fontWeight: 500 }}>Course Name</dt>
        <dd>{name}</dd>
        
        <dt style={{ fontWeight: 500 }}>Status</dt>
        <dd>{status}</dd>
        
        <dt style={{ fontWeight: 500 }}>Start Date</dt>
        <dd>{startDate}</dd>
        
        <dt style={{ fontWeight: 500 }}>End Date</dt>
        <dd>{endDate}</dd>
        
        <dt style={{ fontWeight: 500 }}>Number of Students</dt>
        <dd>{studentsCount}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
