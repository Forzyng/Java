<template>
  <section class="about-me spad">
    <div class="container">
      <div class="row">
        <div class="col-lg-8">
          <div class="about-left">
            <img src="/img/about-me.jpg" alt="">
            <div class="about-title">
              <span>13.10.2022</span>
              <h2>This is <br />About page</h2>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
                ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet. Donec in sodales dui, a
                blandit nunc. Pellentesque id eros venenatis, sollicitudin neque sodales, vehicula nibh.
                Nam massa odio, porttitor vitae efficitur non, ultricies volutpat tellus. Cras egestas
                in lacus a finibus. Suspendisse sed urna at elit condimentum viverra. Suspendisse non
                lobortis nisi. Maecenas accumsan quam quis porta laoreet. Aliquam felis odio, aliquet
                fermentum semper at, porttitor ac mi. Duis vel condimentum risus. Phasellus eu dolor vel
                neque commodo accumsan eget et enim. Pellentesque non elit sed risus tincidunt aliquam
                eu eget metus.</p>
              <p>Donec sit amet enim tortor. Sed egestas nulla nibh, vitae porta velit sagittis eget.
                Donec vitae tellus semper, cursus sem id, iaculis purus. Aenean ligula risus, maximus
                tristique eros vel, auctor ornare tortor. Aliquam vel augue sapien. Duis non auctor
                ante, ac vestibulum tortor. Etiam quis dolor ultricies, dignissim ante a, ornare ipsum.
                Phasellus suscipit rhoncus nulla, quis bibendum tortor elementum ac. Nullam viverra
                tellus diam, nec accumsan orci aliquam sed. Sed placerat sagittis lacus, non rutrum diam
                volutpat id. </p>
            </div>
          </div>
        </div>
        <Recommendation_AlignRight></Recommendation_AlignRight>
      </div>
    </div>
  </section>
  <recommendation_-align-down></recommendation_-align-down>
  <div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
      <div class="search-close-switch">+</div>
      <form class="search-model-form">
        <input type="text" id="search-input" placeholder="Search here.....">
      </form>
    </div>
  </div>
</template>

<script>
import Recommendation_AlignDown from "../../Elements/Recommendation_AlignDown.vue";
import Recommendation_AlignRight from "../../Elements/Recommendation_AlignRight.vue";
export default {
  name: "AboutComponent",
  components: {Recommendation_AlignRight, Recommendation_AlignDown}
}
</script>

<style scoped>

</style>