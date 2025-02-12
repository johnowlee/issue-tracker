import { createRouter, createWebHistory } from "vue-router"
import ProjectsView from "../views/ProjectsView.vue"
import ProjectView from "../views/ProjectView.vue"
import IssueView from "../views/IssueView.vue"

const routes = [
  {
        path: '/',
        redirect: '/projects'
  },
  {
    path: "/projects",
    name: "Projects",
    component: ProjectsView,
  },
  {
    path: "/projects/:id",
    name: "Project",
    component: ProjectView,
  },
  {
    path: "/issues/:id",
    name: "Issue",
    component: IssueView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
