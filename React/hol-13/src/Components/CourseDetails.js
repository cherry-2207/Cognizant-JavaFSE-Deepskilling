import React from "react";

const CourseDetails = () => {
  const courses = [
    { name: "Full Stack Java", duration: "12 Weeks", rating: "4.8/5" },
    { name: "Frontend Mastery with React", duration: "8 Weeks", rating: "4.9/5" },
    { name: "DevOps & Cloud Orchestration", duration: "10 Weeks", rating: "4.7/5" }
  ];

  return (
    <div style={{ padding: "15px", border: "1px solid #f0ad4e", borderRadius: "5px", backgroundColor: "#fffcf5" }}>
      <h3 style={{ color: "#f0ad4e", marginTop: 0 }}>Course Details</h3>
      <table style={{ width: "100%", borderCollapse: "collapse", textAlign: "left" }}>
        <thead>
          <tr style={{ borderBottom: "1px solid #ccc" }}>
            <th style={{ padding: "6px" }}>Course Name</th>
            <th style={{ padding: "6px" }}>Duration</th>
            <th style={{ padding: "6px" }}>Rating</th>
          </tr>
        </thead>
        <tbody>
          {courses.map((course, idx) => (
            <tr key={idx} style={{ borderBottom: "1px solid #eee" }}>
              <td style={{ padding: "8px 6px" }}>{course.name}</td>
              <td style={{ padding: "8px 6px" }}>{course.duration}</td>
              <td style={{ padding: "8px 6px", fontWeight: "bold" }}>{course.rating}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CourseDetails;
