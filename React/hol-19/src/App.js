import React, { useState, useEffect } from "react";
import "./App.css";
import GitClient from "./GitClient";

function App() {
  const [username, setUsername] = useState("techiesyed");
  const [repos, setRepos] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchRepos = async () => {
    setLoading(true);
    setError(null);
    try {
      const client = new GitClient();
      const data = await client.getRepositories(username);
      setRepos(data);
    } catch (err) {
      setError(err.message);
      setRepos([]);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchRepos();
  }, []); // Fetch initial repos on mount

  const handleSubmit = (e) => {
    e.preventDefault();
    fetchRepos();
  };

  return (
    <div style={{ padding: "30px", fontFamily: "sans-serif", maxWidth: "600px", margin: "0 auto" }}>
      <h1 style={{ textAlign: "center", color: "#333", borderBottom: "2px solid #0275d8", paddingBottom: "10px" }}>
        Git Client App
      </h1>

      <form onSubmit={handleSubmit} style={{ display: "flex", gap: "10px", margin: "20px 0" }}>
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          placeholder="Enter GitHub Username"
          style={{ flex: 1, padding: "10px", borderRadius: "4px", border: "1px solid #ccc", fontSize: "16px" }}
          required
        />
        <button
          type="submit"
          style={{
            padding: "10px 20px",
            backgroundColor: "#0275d8",
            color: "#fff",
            border: "none",
            borderRadius: "4px",
            fontSize: "16px",
            fontWeight: "bold",
            cursor: "pointer"
          }}
        >
          Fetch Repos
        </button>
      </form>

      {loading && <p style={{ textAlign: "center", fontWeight: "bold" }}>Loading repositories...</p>}
      
      {error && (
        <p style={{ color: "red", textAlign: "center", fontWeight: "bold" }}>
          Error: {error}
        </p>
      )}

      {!loading && !error && (
        <div>
          <h3>Repositories for {username}:</h3>
          {repos.length === 0 ? (
            <p>No repositories found or user does not exist.</p>
          ) : (
            <ul style={{ listStyleType: "square", paddingLeft: "20px" }}>
              {repos.map((repo, idx) => (
                <li key={idx} style={{ margin: "8px 0" }}>
                  <a
                    href={repo.html_url}
                    target="_blank"
                    rel="noopener noreferrer"
                    style={{ textDecoration: "none", color: "#0275d8", fontWeight: "500" }}
                  >
                    {repo.name}
                  </a>
                  {repo.description && (
                    <p style={{ margin: "2px 0 0 0", fontSize: "13px", color: "#666" }}>
                      {repo.description}
                    </p>
                  )}
                </li>
              ))}
            </ul>
          )}
        </div>
      )}
    </div>
  );
}

export default App;
