import React, { useState } from "react";
import "./App.css";
import FlightDetails, { flights } from "./Components/FlightDetails";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [selectedFlight, setSelectedFlight] = useState("");
  const [passengers, setPassengers] = useState(1);

  const handleBooking = (e) => {
    e.preventDefault();
    if (!selectedFlight) {
      alert("Please select a flight to book.");
      return;
    }
    alert(`Success! Booked ${passengers} ticket(s) for flight ${selectedFlight}.`);
  };

  return (
    <div style={{ padding: "30px", fontFamily: "sans-serif", maxWidth: "800px", margin: "0 auto" }}>
      <header
        style={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
          borderBottom: "2px solid #ddd",
          paddingBottom: "15px",
          marginBottom: "25px"
        }}
      >
        <h1 style={{ margin: 0, color: "#333" }}>Ticket Booking App</h1>
        <button
          onClick={() => {
            setIsLoggedIn(!isLoggedIn);
            setSelectedFlight("");
          }}
          style={{
            padding: "8px 16px",
            fontSize: "14px",
            backgroundColor: isLoggedIn ? "#d9534f" : "#5cb85c",
            color: "#fff",
            border: "none",
            borderRadius: "4px",
            cursor: "pointer",
            fontWeight: "bold"
          }}
        >
          {isLoggedIn ? "Logout" : "Login"}
        </button>
      </header>

      {/* Conditional rendering based on Login Status */}
      {!isLoggedIn ? (
        <div style={{ border: "1px dashed #f0ad4e", padding: "15px", borderRadius: "4px", backgroundColor: "#fcf8e3", color: "#8a6d3b" }}>
          <h2>Guest Page</h2>
          <p>Welcome, Guest! You can browse the flights listed below. Please login to book tickets.</p>
          <FlightDetails />
        </div>
      ) : (
        <div style={{ border: "1px solid #5cb85c", padding: "20px", borderRadius: "6px", backgroundColor: "#f9fff9" }}>
          <h2 style={{ color: "#5cb85c" }}>User Dashboard</h2>
          <p>Welcome back! You are logged in and can now proceed with booking.</p>
          
          <FlightDetails />

          <hr style={{ margin: "25px 0", border: "0", borderTop: "1px solid #eee" }} />

          {/* Ticket Booking Form */}
          <h3>Book Tickets</h3>
          <form onSubmit={handleBooking} style={{ display: "flex", flexDirection: "column", gap: "15px", maxWidth: "400px" }}>
            <div style={{ display: "flex", flexDirection: "column", gap: "5px" }}>
              <label htmlFor="flightSelect">Select Flight:</label>
              <select
                id="flightSelect"
                value={selectedFlight}
                onChange={(e) => setSelectedFlight(e.target.value)}
                style={{ padding: "8px", borderRadius: "4px", border: "1px solid #ccc" }}
                required
              >
                <option value="">-- Choose Flight --</option>
                {flights.map((f) => (
                  <option key={f.id} value={f.id}>
                    {f.id} ({f.from} to {f.to}) - {f.price}
                  </option>
                ))}
              </select>
            </div>

            <div style={{ display: "flex", flexDirection: "column", gap: "5px" }}>
              <label htmlFor="passengerCount">Number of Passengers:</label>
              <input
                id="passengerCount"
                type="number"
                min="1"
                max="10"
                value={passengers}
                onChange={(e) => setPassengers(parseInt(e.target.value))}
                style={{ padding: "8px", borderRadius: "4px", border: "1px solid #ccc" }}
                required
              />
            </div>

            <button
              type="submit"
              style={{
                padding: "10px",
                backgroundColor: "#5cb85c",
                color: "#fff",
                border: "none",
                borderRadius: "4px",
                fontSize: "16px",
                fontWeight: "bold",
                cursor: "pointer"
              }}
            >
              Book Tickets
            </button>
          </form>
        </div>
      )}
    </div>
  );
}

export default App;
