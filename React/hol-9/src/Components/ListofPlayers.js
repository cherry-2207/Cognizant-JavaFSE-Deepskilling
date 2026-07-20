import React from "react";

const ListofPlayers = () => {
  const players = [
    { name: "Sachin Tendulkar", score: 95 },
    { name: "Virat Kohli", score: 85 },
    { name: "Rohit Sharma", score: 75 },
    { name: "MS Dhoni", score: 65 },
    { name: "Yuvraj Singh", score: 55 },
    { name: "Suresh Raina", score: 60 },
    { name: "Hardik Pandya", score: 80 },
    { name: "Ravindra Jadeja", score: 45 },
    { name: "Jasprit Bumrah", score: 30 },
    { name: "Mohammed Shami", score: 25 },
    { name: "KL Rahul", score: 72 }
  ];

  // Filter players with scores below 70 using arrow functions
  const playersBelow70 = players.filter((player) => player.score < 70);
  const players70AndAbove = players.filter((player) => player.score >= 70);

  return (
    <div style={{ fontFamily: "sans-serif", padding: "20px" }}>
      <h2 style={{ color: "#333" }}>List of Players (All 11 Players)</h2>
      <table style={{ borderCollapse: "collapse", width: "400px", marginBottom: "30px" }}>
        <thead>
          <tr style={{ backgroundColor: "#f2f2f2" }}>
            <th style={{ border: "1px solid #ddd", padding: "8px", textAlign: "left" }}>Name</th>
            <th style={{ border: "1px solid #ddd", padding: "8px", textAlign: "left" }}>Score</th>
          </tr>
        </thead>
        <tbody>
          {players.map((p, index) => (
            <tr key={index}>
              <td style={{ border: "1px solid #ddd", padding: "8px" }}>{p.name}</td>
              <td style={{ border: "1px solid #ddd", padding: "8px" }}>{p.score}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <h3 style={{ color: "crimson" }}>Players with Scores Below 70</h3>
      <ul>
        {playersBelow70.map((p, idx) => (
          <li key={idx} style={{ padding: "4px 0", color: "crimson" }}>
            {p.name}: <strong>{p.score}</strong>
          </li>
        ))}
      </ul>

      <h3 style={{ color: "forestgreen" }}>Players with Scores 70 and Above</h3>
      <ul>
        {players70AndAbove.map((p, idx) => (
          <li key={idx} style={{ padding: "4px 0", color: "forestgreen" }}>
            {p.name}: <strong>{p.score}</strong>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
