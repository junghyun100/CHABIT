<template>
  <div id="app" class="app">
    <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
    <v-app id="inspire">
      <v-navigation-drawer v-model="drawer" app temporary color="#a62f22">
        <v-list nav dense shaped>
          <div id="nav-top" class="nav-top">
            <v-list-item>
              <v-list-item-content>
                <div class="nav-top-avatar">
                  <v-list-item-avatar style="height:63px; width:63px; background-color:white; ">
                    <!-- 프로필 사진 입력 -->
                    <v-img
                      v-if="checkLogin()"
                      style="height:60px; min-width: 60px; width:60px;"
                      :src="userImage"
                    ></v-img>
                    <v-img
                      v-else
                      style="height:60px; min-width: 60px; width:60px;"
                      src="./assets/img/avatardefault.png"
                    ></v-img>
                  </v-list-item-avatar>
                </div>
                <div class="nav-top-content">
                  <v-list-item-title v-if="checkLogin()" class="title">
                    {{ userNickname }}
                  </v-list-item-title>
                  <v-list-item-title v-else class="title" @click="$router.push('/login')">
                    로그인하기
                  </v-list-item-title>
                  <v-list-item-subtitle v-if="checkLogin()" color="white">
                    {{ userLevel.level }}
                  </v-list-item-subtitle>
                  <v-list-item-subtitle v-if="checkLogin()">
                    {{ userPoints }}/{{ userLevel.levelMaxPoint }}p
                  </v-list-item-subtitle>
                </div>
              </v-list-item-content>
            </v-list-item>
          </div>
          <v-divider></v-divider>
          <div id="nav-mid" class="nav-mid">
            <v-list-item-group v-model="group" active-class="text--accent-4">
              <v-list-item>
                <v-list-item-title @click="$router.push({ name: 'Home' })">Home</v-list-item-title>
              </v-list-item>

              <v-list-item @click="$router.push({ name: 'Feed' })">
                <v-list-item-title>마이피드</v-list-item-title>
              </v-list-item>

              <v-list-item @click="$router.push('/follow')">
                <v-list-item-title>팔로우</v-list-item-title>
              </v-list-item>

              <v-list-item @click="$router.push({ name: 'Challenge' })">
                <v-list-item-title>챌린지</v-list-item-title>
              </v-list-item>

              <v-list-item @click="$router.push({ name: 'Ranking' })">
                <v-list-item-title>랭킹</v-list-item-title>
              </v-list-item>

              <v-list-item v-if="this.userEmail" @click="$router.push({ name: 'Setting' })">
                <v-list-item-title>설정</v-list-item-title>
              </v-list-item>

              <v-list-item v-if="this.userEmail" class="logout-list" @click="logout">
                <v-icon class="logout-icon" color="white">mdi-logout</v-icon>
                <v-list-item-title>로그아웃</v-list-item-title>
              </v-list-item>
            </v-list-item-group>
          </div>
        </v-list>
      </v-navigation-drawer>

      <transition name="fade">
        <v-app-bar app flat id="navbar" v-if="showNavbar">
          <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
          <!-- <v-toolbar-title  class="flex text-center">{{ pageTitle }}</v-toolbar-title> -->
        </v-app-bar>
        <v-app-bar app flat id="navbar" color="transparent" v-else>
          <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
          <!-- <v-toolbar-title  class="flex text-center">{{ pageTitle }}</v-toolbar-title> -->
        </v-app-bar>
      </transition>
      <v-main>
        <!-- padding을 넣어 줄 경우 내용이 밀림. 선택 -->
        <!-- <v-main style="padding:0"> -->
        <router-view />
      </v-main>
    </v-app>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "App",
  data: () => ({ drawer: null, group: null, showNavbar: false }),
  props: ["pageTitle"],
  computed: {
    ...mapGetters({ userEmail: "getUserEmail" }),
    ...mapGetters({ userLevel: "getUserLevel" }),
    ...mapGetters({ userNickname: "getUserNickname" }),
    ...mapGetters({ userImage: "getUserImage" }),
    ...mapGetters({ userPoints: "getUserPoints" }),
  },
  watch: {
    group() {
      this.drawer = false;
    },
  },
  methods: {
    checkLogin() {
      if (this.userEmail != null) return true;
      else return false;
    },
    scroll() {
      window.pageYOffset > 0 ? (this.showNavbar = true) : (this.showNavbar = false);
    },
    logout() {
      localStorage.removeItem("vuex");
      this.$router.push("/login");
      alert("로그아웃 되었습니다.");
      window.location.reload();
    },
  },
  created() {
    window.addEventListener("scroll", this.scroll);
  },
  destroyed() {
    window.removeEventListener("scroll", this.scroll);
  },
};
</script>
<style scoped>
#app .v-navigation-drawer {
  border-radius: 0 20px 20px 0;
}
#nav-top .v-list-item__title,
#nav-mid .v-list-item__title,
#nav-bottom .v-list-item__title {
  color: white;
}
#nav-top {
  margin: 10% 5% 10% 5%;
}
#nav-top .v-list-item__title {
  line-height: 1.5;
}
#nav-top .v-list-item__content {
  display: contents;
  flex: 1 1;
}
#nav-top .v-list-item__content * {
  flex: 0;
}
#nav-top .v-avatar {
  border-radius: 100%;
}
#nav-mid {
  padding-left: 10px;
}
#nav-mid .v-list-item {
  width: 70%;
}
#nav-mid .v-list-item:hover {
  background-color: white;
  opacity: 0.5;
  box-shadow: 2px 2px 7px #3c0903;
}
#nav-mid .theme--light.v-list-item--active::before {
  background-color: white;
  box-shadow: 2px 2px 7px #3c0903;
  opacity: 0.3;
  color: #a62f22;
}
#nav-mid .v-list-item .v-list-item__title {
  font-size: 20px;
  line-height: normal;
}
#nav-mid .v-list-item .v-list-item__title:hover {
  color: #a62f22;
}
#nav-mid .v-list .v-list-item--active {
  color: #a62f22;
}
#nav-bottom {
  width: 90%;
  margin: 0 auto;
  position: fixed;
  bottom: 30%;
}
#nav-bottom .v-list-item {
  width: fit-content;
  margin: 0 auto;
}
#navbar {
  overflow: hidden;
  background-color: rgb(168, 164, 164, 0.5);
}
.fade-enter-active {
  transition: all 1s;
}
.fade-leave-active {
  transition: all 1s;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>
