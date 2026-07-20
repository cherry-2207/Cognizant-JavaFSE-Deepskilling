import React, { useState } from "react";

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState("");
  const [euros, setEuros] = useState("");
  
  const [inrToEurResult, setInrToEurResult] = useState(null);
  const [eurToInrResult, setEurToInrResult] = useState(null);

  const EXCHANGE_RATE = 90.0; // 1 Euro = 90 Rupees

  const handleInrToEurSubmit = (e) => {
    e.preventDefault();
    const val = parseFloat(rupees);
    if (!isNaN(val)) {
      setInrToEurResult((val / EXCHANGE_RATE).toFixed(2));
    } else {
      setInrToEurResult(null);
    }
  };

  const handleEurToInrSubmit = (e) => {
    e.preventDefault();
    const val = parseFloat(euros);
    if (!isNaN(val)) {
      setEurToInrResult((val * EXCHANGE_RATE).toFixed(2));
    } else {
      setEurToInrResult(null);
    }
  };

  return (
    <div style={{ fontFamily: "sans-serif", padding: "20px", border: "1px solid #ccc", borderRadius: "8px" }}>
      <h2>Currency Converter (Exchange Rate: 1 EUR = {EXCHANGE_RATE} INR)</h2>

      {/* INR to Euro Form */}
      <form onSubmit={handleInrToEurSubmit} style={{ marginBottom: "25px" }}>
        <h3>Convert Indian Rupees (INR) to Euro (EUR)</h3>
        <div style={{ display: "flex", gap: "10px", alignItems: "center" }}>
          <label htmlFor="inrInput">Rupees (INR):</label>
          <input
            id="inrInput"
            type="number"
            value={rupees}
            onChange={(e) => setRupees(e.target.value)}
            placeholder="Enter Amount in INR"
            style={{ padding: "8px", borderRadius: "4px", border: "1px solid #ccc" }}
          />
          <button
            type="submit"
            style={{ padding: "8px 16px", backgroundColor: "#333", color: "#fff", border: "none", borderRadius: "4px", cursor: "pointer" }}
          >
            Convert to Euro
          </button>
        </div>
        {inrToEurResult !== null && (
          <p style={{ marginTop: "10px", fontSize: "16px", color: "green", fontWeight: "bold" }}>
            Result: € {inrToEurResult} Euros
          </p>
        )}
      </form>

      {/* Euro to INR Form */}
      <form onSubmit={handleEurToInrSubmit}>
        <h3>Convert Euro (EUR) to Indian Rupees (INR)</h3>
        <div style={{ display: "flex", gap: "10px", alignItems: "center" }}>
          <label htmlFor="eurInput">Euros (EUR):</label>
          <input
            id="eurInput"
            type="number"
            value={euros}
            onChange={(e) => setEuros(e.target.value)}
            placeholder="Enter Amount in EUR"
            style={{ padding: "8px", borderRadius: "4px", border: "1px solid #ccc" }}
          />
          <button
            type="submit"
            style={{ padding: "8px 16px", backgroundColor: "#333", color: "#fff", border: "none", borderRadius: "4px", cursor: "pointer" }}
          >
            Convert to Rupees
          </button>
        </div>
        {eurToInrResult !== null && (
          <p style={{ marginTop: "10px", fontSize: "16px", color: "green", fontWeight: "bold" }}>
            Result: ₹ {eurToInrResult} Rupees
          </p>
        )}
      </form>
    </div>
  );
};

export default CurrencyConvertor;
