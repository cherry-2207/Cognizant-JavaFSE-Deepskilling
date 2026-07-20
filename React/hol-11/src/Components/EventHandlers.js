import React, { useState } from "react";

const EventHandlers = () => {
  const [counter, setCounter] = useState(0);

  // Increase button invokes multiple methods/logic
  const handleIncrement = (e) => {
    // 1. Increment value
    setCounter((prev) => prev + 1);
    // 2. Say Hello followed by a static message
    console.log("Hello! Counter incremented.");
    alert("Hello! The count is now " + (counter + 1));
  };

  const handleDecrement = () => {
    setCounter((prev) => prev - 1);
  };

  // Method taking parameter
  const handleSayWelcome = (msg) => {
    alert(`Received: ${msg}! Welcome to React Events.`);
  };

  // OnPress synthetic event
  const handleSyntheticEvent = (e) => {
    alert(`Event Type: ${e.type}. Message: I was clicked!`);
  };

  return (
    <div style={{ fontFamily: "sans-serif", padding: "20px", border: "1px solid #ccc", borderRadius: "8px", marginBottom: "20px" }}>
      <h2>Event Examples Component</h2>
      
      {/* Counter Section */}
      <div style={{ marginBottom: "20px" }}>
        <h3>Counter: {counter}</h3>
        <button
          onClick={handleIncrement}
          style={{ marginRight: "10px", padding: "8px 16px", backgroundColor: "#008cba", color: "#fff", border: "none", borderRadius: "4px", cursor: "pointer" }}
        >
          Increment
        </button>
        <button
          onClick={handleDecrement}
          style={{ padding: "8px 16px", backgroundColor: "#f44336", color: "#fff", border: "none", borderRadius: "4px", cursor: "pointer" }}
        >
          Decrement
        </button>
      </div>

      {/* Parameter Passing Section */}
      <div style={{ marginBottom: "20px" }}>
        <h3>Parameter Passing</h3>
        <button
          onClick={() => handleSayWelcome("welcome")}
          style={{ padding: "8px 16px", backgroundColor: "#4caf50", color: "#fff", border: "none", borderRadius: "4px", cursor: "pointer" }}
        >
          Say Welcome
        </button>
      </div>

      {/* Synthetic Event Section */}
      <div>
        <h3>Synthetic Event Demonstration</h3>
        <button
          onClick={handleSyntheticEvent}
          style={{ padding: "8px 16px", backgroundColor: "#e7e7e7", color: "#000", border: "1px solid #ccc", borderRadius: "4px", cursor: "pointer" }}
        >
          OnPress Event Trigger
        </button>
      </div>
    </div>
  );
};

export default EventHandlers;
