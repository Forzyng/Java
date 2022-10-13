<template>
  <div class="hero-search set-bg" style="background-image: url(/img/search-bg.jpg)">
    <div class="container">
      <div class="filter-table">
        <form action="#" class="filter-search">
          <input type="text" placeholder="Search recipe">
          <select data-size="5" id="category" class=" d-inline form-select form-select-lg mb-3" aria-label=".form-select-lg example" style="width: 300px; height: 54px; ">
            <option selected>Category</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
          </select>
          <select data-size="5" id="tag" class=" d-inline form-select form-select-lg mb-3" aria-label=".form-select-lg example" style="width: 300px; height: 54px; margin-left: 10px">
            <option selected>Open this select menu</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
          </select>
          <button type="submit" style="margin-left: 10px">Search</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Search-Section"
}
</script>

<style scoped>

</style>