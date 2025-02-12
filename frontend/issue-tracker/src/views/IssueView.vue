<template>
  <div class="issue-page">
    <!-- 좌측: 이슈 내용 및 코멘트 -->
    <div class="issue-content">
      <h1 class="issue-title">{{ issue.title }}</h1>
      <p class="issue-description">{{ issue.description }}</p>

      <div class="comments-section">
        <h3>💬 코멘트</h3>
        <div v-for="(comment, index) in comments" :key="index" class="comment">
          <p class="comment-author">{{ comment.author }}</p>
          <p class="comment-text">{{ comment.text }}</p>
        </div>
      </div>
    </div>

    <!-- 우측: 담당자, 라벨, 프로젝트 -->
    <aside class="issue-sidebar">
      <div class="sidebar-section">
        <h3>🧑‍💻 담당자</h3>
        <div class="chips">
          <span class="chip" v-for="(item, index) in assignees" :key="index">
            {{ item.name }}
          </span>
        </div>
      </div>

      <div class="sidebar-section">
        <h3>🏷️ 라벨</h3>
        <div class="chips">
          <span class="chip label" v-for="(item, index) in labels" :key="index">
            {{ item.name }}
          </span>
        </div>
      </div>

      <div class="sidebar-section">
        <h3>📂 프로젝트</h3>
        <p class="project-title">{{ project.title }}</p>
      </div>
    </aside>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['fetchedIssue']),
    issue() {
      return this.fetchedIssue.issue;
    },
    assignees() {
      return this.fetchedIssue.assignees;
    },
    project() {
      return this.fetchedIssue.project;
    },
    labels() {
      return this.fetchedIssue.labels;
    },
    comments() {
      return this.fetchedIssue.comments || []; // 코멘트 목록
    }
  },
  created() {
    const id = this.$route.params.id;
    this.$store.dispatch('FETCH_ISSUE', id);
  }
}
</script>

<style scoped>
/* 전체 레이아웃 */
.issue-page {
  display: flex;
  max-width: 1000px;
  margin: 40px auto;
  gap: 20px;
}

/* 좌측: 이슈 상세 */
.issue-content {
  flex: 2;
  padding: 20px;
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

/* 우측: 담당자, 라벨, 프로젝트 */
.issue-sidebar {
  flex: 1;
  padding: 20px;
  background-color: #f8f9fa;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

/* 이슈 제목 */
.issue-title {
  font-size: 24px;
  font-weight: bold;
  color: #333;
}

/* 이슈 설명 */
.issue-description {
  font-size: 16px;
  color: #666;
  margin-bottom: 10px;
}

/* 코멘트 스타일 */
.comments-section {
  margin-top: 20px;
}

.comment {
  border-bottom: 1px solid #ddd;
  padding: 10px 0;
}

.comment-author {
  font-weight: bold;
  color: #007bff;
}

.comment-text {
  color: #333;
}

/* 우측 섹션 스타일 */
.sidebar-section {
  margin-bottom: 20px;
}

/* 프로젝트 제목 */
.project-title {
  font-size: 18px;
  font-weight: bold;
  color: #007bff;
}

/* 담당자 및 라벨 스타일 */
.chips {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
}

.chip {
  display: inline-block;
  padding: 6px 12px;
  border-radius: 20px;
  background-color: #f1f1f1;
  font-size: 14px;
  font-weight: bold;
  color: #333;
}

.chip.label {
  background-color: #eaf5ff;
  color: #007bff;
  border: 1px solid #007bff;
}

/* 반응형 */
@media (max-width: 768px) {
  .issue-page {
    flex-direction: column;
  }

  .issue-sidebar {
    order: -1;
    /* 모바일에서는 사이드바가 위로 */
  }
}
</style>