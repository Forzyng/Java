<template>
    <div class="main_bg">
        <div class="content">
            <div class="container_12">
                <about-us-staff></about-us-staff>
                <what-we-offers></what-we-offers>
            </div>
        </div>
    </div>
</template>

<script>
import AboutUsStaff from "../components/About/AboutUsStaff";
import WhatWeOffers from "../components/About/WhatWeOffers";
export default {
    name: "PageAbout",
    components: {WhatWeOffers, AboutUsStaff}
}
</script>

<style scoped>

</style>
