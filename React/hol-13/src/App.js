import React, { useState } from "react";
import "./App.css";
import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {
  const [selectedView, setSelectedView] = useState("book");
  const [renderMethod, setRenderMethod] = useState("elementVariable");

  // Helper method using switch (Method 1)
  const renderWithSwitch = () => {
    switch (selectedView) {
      case "book":
        return <BookDetails />;
      case "blog":
        return <BlogDetails />;
      case "course":
        return <CourseDetails />;
      default:
        return null;
    }
  };

  // Helper using element variables (Method 2)
  let elementVariableComponent;
  if (selectedView === "book") {
    elementVariableComponent = <BookDetails />;
  } else if (selectedView === "blog") {
    elementVariableComponent = <BlogDetails />;
  } else if (selectedView === "course") {
    elementVariableComponent = <CourseDetails />;
  }

  return (
    <div style={{ padding: "30px", fontFamily: "sans-serif", maxWidth: "800px", margin: "0 auto" }}>
      <h1 style={{ textAlign: "center", color: "#333", borderBottom: "2px solid #eee", paddingBottom: "10px" }}>
        Blogger App - Conditional Rendering
      </h1>

      {/* Select Controls */}
      <div style={{ display: "flex", gap: "20px", marginBottom: "25px", flexWrap: "wrap" }}>
        <div>
          <label htmlFor="viewSelect" style={{ fontWeight: "bold", marginRight: "10px" }}>Select Component to Display:</label>
          <select
            id="viewSelect"
            value={selectedView}
            onChange={(e) => setSelectedView(e.target.value)}
            style={{ padding: "8px", borderRadius: "4px", border: "1px solid #ccc" }}
          >
            <option value="book">Book Details</option>
            <option value="blog">Blog Details</option>
            <option value="course">Course Details</option>
          </select>
        </div>

        <div>
          <label htmlFor="methodSelect" style={{ fontWeight: "bold", marginRight: "10px" }}>Conditional Rendering Method:</label>
          <select
            id="methodSelect"
            value={renderMethod}
            onChange={(e) => setRenderMethod(e.target.value)}
            style={{ padding: "8px", borderRadius: "4px", border: "1px solid #ccc" }}
          >
            <option value="elementVariable">Element Variable (if-else)</option>
            <option value="ternary">Ternary Operator (? :)</option>
            <option value="logicalAnd">Logical AND (&&)</option>
            <option value="switchCase">Switch Case Method</option>
          </select>
        </div>
      </div>

      <div style={{ padding: "20px", border: "1px solid #ddd", borderRadius: "8px", minHeight: "200px" }}>
        <h4 style={{ color: "#888", marginTop: 0 }}>
          Rendering via: <code style={{ color: "crimson" }}>{renderMethod}</code>
        </h4>

        {/* Conditional Rendering Outputs */}
        {renderMethod === "elementVariable" && elementVariableComponent}

        {renderMethod === "switchCase" && renderWithSwitch()}

        {renderMethod === "ternary" && (
          selectedView === "book" ? (
            <BookDetails />
          ) : selectedView === "blog" ? (
            <BlogDetails />
          ) : (
            <CourseDetails />
          )
        )}

        {renderMethod === "logicalAnd" && (
          <div>
            {selectedView === "book" && <BookDetails />}
            {selectedView === "blog" && <BlogDetails />}
            {selectedView === "course" && <CourseDetails />}
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
