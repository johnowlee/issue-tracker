<template>
  <div class="project-container">
    <!-- 프로젝트 정보 -->
    <div class="project-header">
      <h1 class="project-title">{{ fetchedProject.project.title }}</h1>
      <p class="project-description">{{ fetchedProject.project.description }}</p>
      <div class="project-dates">
        <p><strong>📅 시작일:</strong> {{ fetchedProject.project.startDate }}</p>
        <p><strong>🛑 종료일:</strong> {{ fetchedProject.project.endDate }}</p>
      </div>
    </div>

    <hr />

    <!-- 이슈 목록 -->
    <div class="issues-section">
      <h2>🚀 이슈 목록</h2>
      <div class="issue-list">
        <div class="issue-card" v-for="(item, index) in fetchedProject.issues" :key="index">
          <!-- 이슈 제목 + 라벨을 한 줄로 정렬 -->
          <div class="issue-header">
            <router-link :to="`/issues/${item.issue.id}`" class="issue-title">
              {{ item.issue.title }}
            </router-link>
            <div class="labels">
              <span v-for="(label, idx) in item.labels" :key="idx" class="label">
                {{ label.name }}
              </span>
            </div>
          </div>
          <p class="issue-meta">🔗 Opened on {{ item.issue.startDate }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['fetchedProject'])
  },
  created() {
    const id = this.$route.params.id;
    this.$store.dispatch('FETCH_PROJECT', id);
  }
}
</script>

<style scoped>
/* 전체 컨테이너 */
.project-container {
  max-width: 1000px;
  margin: 40px auto;
  padding: 20px;
}

/* 프로젝트 제목 */
.project-title {
  font-size: 24px;
  font-weight: bold;
  color: #333;
  margin-bottom: 10px;
}

/* 프로젝트 설명 */
.project-description {
  font-size: 16px;
  color: #666;
  margin-bottom: 15px;
}

/* 프로젝트 날짜 정보 */
.project-dates {
  font-size: 14px;
  color: #555;
}

/* 구분선 */
hr {
  margin: 20px 0;
  border: none;
  border-top: 1px solid #ddd;
}

/* 이슈 섹션 */
.issues-section {
  margin-top: 20px;
}

/* 이슈 리스트 */
.issue-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

/* 개별 이슈 카드 */
.issue-card {
  background: #fff;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 15px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  transition: transform 0.2s ease-in-out;
}

.issue-card:hover {
  transform: translateY(-3px);
}

/* 이슈 제목과 라벨을 한 줄로 정렬 */
.issue-header {
  display: flex;
  align-items: center;
  gap: 10px;
  flex-wrap: wrap;
}

/* 이슈 제목 스타일 */
.issue-title {
  font-size: 18px;
  font-weight: bold;
  color: #007bff;
  text-decoration: none;
}

.issue-title:hover {
  text-decoration: underline;
}

/* 라벨 스타일 (이슈 제목 옆) */
.labels {
  display: flex;
  gap: 5px;
}

.label {
  display: inline-block;
  padding: 3px 8px;
  border-radius: 12px;
  font-size: 12px;
  font-weight: bold;
  background-color: #eaf5ff;
  color: #007bff;
  border: 1px solid #007bff;
}

/* 이슈 날짜 (opened on) */
.issue-meta {
  font-size: 14px;
  color: #666;
  margin-top: 5px;
}

/* 반응형 */
@media (max-width: 768px) {
  .project-container {
    padding: 15px;
  }

  .issue-list {
    flex-direction: column;
  }

  .issue-header {
    flex-direction: row;
    align-items: center;
    flex-wrap: wrap;
  }
}
</style>
