import axios from "axios";
import GitClient from "./GitClient";

jest.mock("axios");

describe("Git Client Tests", () => {
  test("should return repository names for techiesyed", async () => {
    const dummyRepos = [
      { name: "react-exercises" },
      { name: "java-deepskilling" },
      { name: "microservices-patterns" }
    ];

    // Mock axios.get to return dummy data
    axios.get.mockResolvedValue({ data: dummyRepos });

    const client = new GitClient();
    const repos = await client.getRepositories("techiesyed");

    // Verify it returns the mocked data
    expect(repos).toEqual(dummyRepos);
    expect(repos[0].name).toBe("react-exercises");
    
    // Verify axios.get was called with the correct GitHub API URL
    expect(axios.get).toHaveBeenCalledWith("https://api.github.com/users/techiesyed/repos");
  });
});
