<template>
  <search-section></search-section>
  <top5posts></top5posts>
  <top5-recipes></top5-recipes>
<!--  <top5-articles></top5-articles>-->
  <top5categories></top5categories>
  <random2-recipes></random2-recipes>
</template>

<script>
import SearchSection from "../../Head-Footer-Other/SearchSection.vue";
import Top5Recipes from "./Recipes/Top5Recipes.vue";
import Top5categories from "./Recipes/Top5categories.vue";
import Random2Recipes from "./Recipes/Random2Recipes.vue";
import Top5posts from "./Posts/Top5Posts.vue";
import Top5Articles from "./Articles/Top5Articles.vue";
export default {
  name: "HomeComponent",
  components: {Top5Articles, Top5posts, Random2Recipes, Top5categories, Top5Recipes, SearchSection}
}
</script>

<style scoped>

</style>