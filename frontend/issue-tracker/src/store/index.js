import Vuex from 'vuex'
import { fetchProjects, fetchProject, fetchIssue } from '../api/index.js'

export const store = new Vuex.Store({
  state: {
    projects: [],
    project: {},
    issue: {}
  },
  getters: {
    fetchedProjects(state) {
      return state.projects
    },
    fetchedProject(state) {
      return state.project
    },
    fetchedIssue(state) {
      return state.issue
    }
  },
  mutations: {
    SET_PROJECTS(state, projects) {
      state.projects = projects
    },
    SET_PROJECT(state, project) {
      state.project = project
    },
    SET_ISSUE(state, issue) {
      state.issue = issue
    }
  },
  actions: {
    FETCH_PROJECTS(context) {
      fetchProjects()
        .then(response => context.commit('SET_PROJECTS', response.data))
        .catch(error => console.log(error))
    },
    FETCH_PROJECT(context, id) {
      fetchProject(id)
        .then(response => context.commit('SET_PROJECT', response.data))
        .catch(error => console.log(error))
    },
    FETCH_ISSUE(context, id) {
      fetchIssue(id)
        .then(response => context.commit('SET_ISSUE', response.data))
        .catch(error => console.log(error))
    }
  }
})
