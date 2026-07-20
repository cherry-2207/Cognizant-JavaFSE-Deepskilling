import axios from "axios";

class GitClient {
  async getRepositories(username) {
    try {
      const response = await axios.get(`https://api.github.com/users/${username}/repos`);
      // Return list of repository objects
      return response.data;
    } catch (error) {
      throw new Error(`Failed to fetch repositories: ${error.message}`);
    }
  }
}

export default GitClient;
export { GitClient };
