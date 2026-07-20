import React from "react";

const IndianPlayers = () => {
  const indianTeam = [
    "Jasprit Bumrah", // Index 0 (1st)
    "Ravindra Jadeja", // Index 1 (2nd)
    "Hardik Pandya", // Index 2 (3rd)
    "Rishabh Pant", // Index 3 (4th)
    "Axar Patel", // Index 4 (5th)
    "Shubman Gill" // Index 5 (6th)
  ];

  // Destructure the players
  const [first, second, third, fourth, fifth, sixth] = indianTeam;

  const oddTeam = [first, third, fifth];   // 1st, 3rd, 5th
  const evenTeam = [second, fourth, sixth]; // 2nd, 4th, 6th

  // Two arrays for T20 and Ranji Trophy players
  const T20players = ["Suryakumar Yadav", "Yashasvi Jaiswal", "Sanju Samson"];
  const RanjiTrophy = ["Sarfaraz Khan", "Abhimanyu Easwaran", "Sai Sudharsan"];

  // Merge the two arrays using spread operator
  const mergedPlayers = [...T20players, ...RanjiTrophy];

  return (
    <div style={{ fontFamily: "sans-serif", padding: "20px" }}>
      <h2 style={{ color: "#333" }}>Indian Players</h2>
      
      <div style={{ display: "flex", gap: "50px", marginBottom: "30px" }}>
        <div>
          <h3>Odd Team Players (1st, 3rd, 5th)</h3>
          <ul>
            {oddTeam.map((p, i) => <li key={i}>{p}</li>)}
          </ul>
        </div>
        <div>
          <h3>Even Team Players (2nd, 4th, 6th)</h3>
          <ul>
            {evenTeam.map((p, i) => <li key={i}>{p}</li>)}
          </ul>
        </div>
      </div>

      <h3 style={{ color: "#444" }}>Merged squad (T20 + Ranji Trophy)</h3>
      <table style={{ borderCollapse: "collapse", width: "300px" }}>
        <thead>
          <tr style={{ backgroundColor: "#f2f2f2" }}>
            <th style={{ border: "1px solid #ddd", padding: "8px", textAlign: "left" }}>Player Name</th>
          </tr>
        </thead>
        <tbody>
          {mergedPlayers.map((p, i) => (
            <tr key={i}>
              <td style={{ border: "1px solid #ddd", padding: "8px" }}>{p}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default IndianPlayers;
