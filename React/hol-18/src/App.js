import React from "react";
import "./App.css";
import CohortDetails from "./Components/CohortDetails";
import { CohortData } from "./Cohort";

function App() {
  return (
    <div style={{ padding: "20px" }}>
      <h1>Cohort Testing App</h1>
      <CohortDetails cohort={CohortData[0]} />
    </div>
  );
}

export default App;
