import axios from 'axios' // package.json의 라이브러리

const config = {
  baseUrl: 'http://localhost:8080/api/'
}

function fetchProjects() {
  return axios.get(`${config.baseUrl}projects`)
}
function fetchProject(id) {
  return axios.get(`${config.baseUrl}projects/${id}`)
}
function fetchIssue(id) {
  return axios.get(`${config.baseUrl}issues/${id}`)
}

export {
  fetchProjects,
  fetchProject,
  fetchIssue
}