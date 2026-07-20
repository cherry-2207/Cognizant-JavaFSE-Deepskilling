import "./App.css";
import CohortDetails from "./Components/CohortDetails";

const mockCohorts = [
  {
    code: "ADM23CH001",
    name: "Java Full Stack Engineering",
    status: "ongoing",
    startDate: "2026-05-15",
    endDate: "2026-08-15",
    studentsCount: 32
  },
  {
    code: "ADM23CH002",
    name: "React Developer Program",
    status: "completed",
    startDate: "2026-02-01",
    endDate: "2026-04-30",
    studentsCount: 28
  },
  {
    code: "ADM23CH003",
    name: "Cloud Native Applications",
    status: "ongoing",
    startDate: "2026-06-01",
    endDate: "2026-09-01",
    studentsCount: 40
  },
  {
    code: "ADM23CH004",
    name: "Python Data Science",
    status: "completed",
    startDate: "2026-01-10",
    endDate: "2026-04-10",
    studentsCount: 25
  }
];

function App() {
  return (
    <div style={{ padding: "30px", backgroundColor: "#f4f6f8", minHeight: "100vh" }}>
      <h1 style={{ textAlign: "center", color: "#333", fontFamily: "sans-serif", marginBottom: "30px" }}>
        Cognizant Academy Cohorts Dashboard
      </h1>
      <div style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}>
        {mockCohorts.map((cohort) => (
          <CohortDetails key={cohort.code} cohort={cohort} />
        ))}
      </div>
    </div>
  );
}

export default App;
