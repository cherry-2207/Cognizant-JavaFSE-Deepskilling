import React, { useState } from "react";
import "./App.css";
import EmployeesList from "./Components/EmployeesList";
import ThemeContext from "./ThemeContext";

const mockEmployees = [
  { id: 101, name: "Alice Watson", role: "Software Engineer", dept: "Engineering" },
  { id: 102, name: "Bob Miller", role: "HR Specialist", dept: "Human Resources" },
  { id: 103, name: "David Chen", role: "Product Manager", dept: "Product" },
  { id: 104, name: "Emily Davis", role: "UX Designer", dept: "Design" }
];

function App() {
  const [theme, setTheme] = useState("light");

  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div
        style={{
          padding: "30px",
          fontFamily: "sans-serif",
          minHeight: "100vh",
          backgroundColor: theme === "light" ? "#f4f6f8" : "#222",
          color: theme === "light" ? "#333" : "#fff",
          transition: "all 0.3s ease"
        }}
      >
        <header
          style={{
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            borderBottom: `2px solid ${theme === "light" ? "#ddd" : "#444"}`,
            paddingBottom: "15px",
            marginBottom: "25px"
          }}
        >
          <h1 style={{ margin: 0 }}>Employee Directory (Context API)</h1>
          <button
            onClick={toggleTheme}
            style={{
              padding: "10px 20px",
              fontSize: "14px",
              cursor: "pointer",
              backgroundColor: theme === "light" ? "#333" : "#f4f6f8",
              color: theme === "light" ? "#fff" : "#333",
              border: "none",
              borderRadius: "4px",
              fontWeight: "bold"
            }}
          >
            Switch to {theme === "light" ? "Dark Theme" : "Light Theme"}
          </button>
        </header>

        <EmployeesList employees={mockEmployees} />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
