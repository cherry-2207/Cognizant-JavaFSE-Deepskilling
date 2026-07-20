import React from "react";
import styles from "./CohortDetails.module.css";

const CohortDetails = ({ cohort }) => {
  const { code, name, status, startDate, endDate, studentsCount } = cohort;
  
  // h3 color ongoing -> green, otherwise -> blue
  const h3Style = {
    color: status === "ongoing" ? "green" : "blue",
    marginTop: 0,
    borderBottom: "1px solid #eee",
    paddingBottom: "8px"
  };

  return (
    <div className={styles.box}>
      <h3 style={h3Style}>{code}</h3>
      <dl>
        <dt>Course Name</dt>
        <dd>{name}</dd>
        
        <dt>Status</dt>
        <dd style={{ textTransform: "capitalize", fontWeight: "bold" }}>{status}</dd>
        
        <dt>Start Date</dt>
        <dd>{startDate}</dd>
        
        <dt>End Date</dt>
        <dd>{endDate}</dd>
        
        <dt>Number of Students</dt>
        <dd>{studentsCount}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
