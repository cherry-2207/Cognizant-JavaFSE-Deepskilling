import "./App.css";
import EventHandlers from "./Components/EventHandlers";
import CurrencyConvertor from "./Components/CurrencyConvertor";

function App() {
  return (
    <div style={{ padding: "30px", fontFamily: "sans-serif", maxWidth: "800px", margin: "0 auto" }}>
      <h1 style={{ textAlign: "center", color: "#333", borderBottom: "2px solid #ccc", paddingBottom: "10px" }}>
        React Events App
      </h1>
      <EventHandlers />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
