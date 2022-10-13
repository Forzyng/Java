<template>
  <search-section></search-section>
  <AboutComponent></AboutComponent>
</template>

<style>
@media (min-width: 1024px) {

}
</style>
<script>

import AboutComponent from "../components/Home/About/AboutComponent.vue";
import SearchSection from "../components/Head-Footer-Other/SearchSection.vue";
export default {
  components: {SearchSection, AboutComponent}
}
</script>