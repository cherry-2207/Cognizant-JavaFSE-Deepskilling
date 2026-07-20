import React from "react";

const flights = [
  { id: "FL101", from: "Kolkata", to: "Delhi", time: "10:00 AM", price: "₹ 5500" },
  { id: "FL102", from: "Mumbai", to: "Bangalore", time: "02:30 PM", price: "₹ 4200" },
  { id: "FL103", from: "Chennai", to: "Hyderabad", time: "06:15 PM", price: "₹ 3500" },
  { id: "FL104", from: "Delhi", to: "Mumbai", time: "09:45 PM", price: "₹ 6200" }
];

export const FlightDetails = () => {
  return (
    <div style={{ fontFamily: "sans-serif", margin: "20px 0" }}>
      <h3>Available Flights</h3>
      <table style={{ width: "100%", borderCollapse: "collapse", textAlign: "left" }}>
        <thead>
          <tr style={{ backgroundColor: "#f2f2f2" }}>
            <th style={{ border: "1px solid #ddd", padding: "10px" }}>Flight ID</th>
            <th style={{ border: "1px solid #ddd", padding: "10px" }}>Route</th>
            <th style={{ border: "1px solid #ddd", padding: "10px" }}>Departure</th>
            <th style={{ border: "1px solid #ddd", padding: "10px" }}>Price</th>
          </tr>
        </thead>
        <tbody>
          {flights.map((flight) => (
            <tr key={flight.id}>
              <td style={{ border: "1px solid #ddd", padding: "10px" }}>{flight.id}</td>
              <td style={{ border: "1px solid #ddd", padding: "10px" }}>
                {flight.from} &rarr; {flight.to}
              </td>
              <td style={{ border: "1px solid #ddd", padding: "10px" }}>{flight.time}</td>
              <td style={{ border: "1px solid #ddd", padding: "10px", fontWeight: "bold" }}>{flight.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FlightDetails;
export { flights };
