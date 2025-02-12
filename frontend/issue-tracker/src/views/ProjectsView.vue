<template>
  <div class="projects-container">
    <h1 class="page-title">📌 프로젝트 목록</h1>

    <div class="projects-grid">
      <div class="project-card" v-for="(item, index) in fetchedProjects" :key="index">
        <router-link :to="`/projects/${item.id}`" class="project-title">
          {{ item.title }}
        </router-link>
        <div class="project-meta">
          <p><strong>📅 시작일:</strong> {{ item.startDate }}</p>
          <p><strong>🛑 종료일:</strong> {{ item.endDate }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['fetchedProjects'])
  },
  created() {
    this.$store.dispatch('FETCH_PROJECTS')
  }
}
</script>

<style scoped>
/* 전체 컨테이너 */
.projects-container {
  max-width: 1000px;
  margin: 40px auto;
  padding: 20px;
}

/* 페이지 제목 */
.page-title {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
  color: #333;
}

/* 프로젝트 카드 그리드 */
.projects-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 20px;
}

/* 프로젝트 카드 */
.project-card {
  background: #fff;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 15px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  transition: transform 0.2s ease-in-out;
}

.project-card:hover {
  transform: translateY(-5px);
}

/* 프로젝트 제목 */
.project-title {
  font-size: 18px;
  font-weight: bold;
  color: #007bff;
  text-decoration: none;
}

.project-title:hover {
  text-decoration: underline;
}

/* 프로젝트 메타 정보 */
.project-meta {
  margin-top: 10px;
  font-size: 14px;
  color: #555;
}

/* 반응형 */
@media (max-width: 768px) {
  .projects-grid {
    grid-template-columns: 1fr;
  }
}
</style>
