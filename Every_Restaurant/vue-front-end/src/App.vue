<script setup>
import HeaderRoutes from "./components/HeadAndFooter/Header-Routes.vue";
import StaticFooter from "./components/HeadAndFooter/StaticFooter.vue";
</script>

<template>
 <header-routes></header-routes>
  <router-view/>
  <static-footer></static-footer>
</template>

<style scoped>

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }
}
</style>
