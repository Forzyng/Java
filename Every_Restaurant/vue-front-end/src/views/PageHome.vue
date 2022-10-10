<template>
    <div class="main_bg">
        <div class="content page1" style="background: #e5e5e5;">
            <latest-properties></latest-properties>
            <div class="clear"></div>
            <home-about></home-about>
            <div class="clear"></div>
           <featured-properties></featured-properties>
            <div class="clear"></div>
           <how-we-works></how-we-works>
        </div>
    </div>
</template>

<script>

import {useAuthStore} from "../store/auth";
import {useUserStore} from "../store/user";
import LatestProperties from "../components/Home/LatestProperties";
import HomeAbout from "../components/Home/HomeAbout";
import FeaturedProperties from "../components/Home/FeaturedProperties";
import HowWeWorks from "../components/Home/HowWeWorks";
import LoadingComponent from "../components/Loading/LoadingComponent";

export default {
    name: "PageHome",
    components: {HowWeWorks, FeaturedProperties, HomeAbout, LatestProperties}
}
</script>

<style scoped>

</style>



