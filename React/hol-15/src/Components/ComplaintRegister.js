import React, { useState } from "react";

const ComplaintRegister = () => {
  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!employeeName.trim() || !complaint.trim()) {
      alert("Please fill in both the name and complaint fields.");
      return;
    }
    
    // Generate a random 5-digit reference number
    const referenceNumber = Math.floor(Math.random() * 90000) + 10000;
    
    alert(
      `Complaint Submitted Successfully!\n\nDear ${employeeName}, your complaint has been registered.\nReference Number: ${referenceNumber}\nWe will get back to you shortly.`
    );

    // Reset Form
    setEmployeeName("");
    setComplaint("");
  };

  return (
    <div style={{ fontFamily: "sans-serif", padding: "20px", maxWidth: "500px", margin: "20px auto", border: "1px solid #ccc", borderRadius: "8px", boxShadow: "0 2px 4px rgba(0,0,0,0.1)" }}>
      <h2 style={{ color: "#333", borderBottom: "2px solid #333", paddingBottom: "8px" }}>
        Register a Complaint
      </h2>
      <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column", gap: "15px", marginTop: "15px" }}>
        <div style={{ display: "flex", flexDirection: "column", gap: "5px" }}>
          <label htmlFor="empName" style={{ fontWeight: "bold" }}>Employee Name:</label>
          <input
            id="empName"
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            placeholder="Enter your name"
            style={{ padding: "10px", borderRadius: "4px", border: "1px solid #ccc" }}
            required
          />
        </div>

        <div style={{ display: "flex", flexDirection: "column", gap: "5px" }}>
          <label htmlFor="complaintText" style={{ fontWeight: "bold" }}>Complaint Details:</label>
          <textarea
            id="complaintText"
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            placeholder="Describe your complaint here..."
            rows="5"
            style={{ padding: "10px", borderRadius: "4px", border: "1px solid #ccc", resize: "vertical" }}
            required
          />
        </div>

        <button
          type="submit"
          style={{
            padding: "10px 20px",
            backgroundColor: "#d9534f",
            color: "#fff",
            border: "none",
            borderRadius: "4px",
            fontSize: "16px",
            fontWeight: "bold",
            cursor: "pointer",
            transition: "background-color 0.2s"
          }}
        >
          Submit Complaint
        </button>
      </form>
    </div>
  );
};

export default ComplaintRegister;
