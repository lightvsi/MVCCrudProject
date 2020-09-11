<template>
  <div>
    <h1>SpringMVCApp</h1>
    <hr>
    <Time></Time>
    <Orders></Orders>
    <Goods></Goods>
  </div>
</template>

<script>
import Goods from "@/components/Goods";
import Orders from "@/components/Orders";
import Time from "@/components/Time";
export default {
  name: "TableView",
  components: {
    Time,
    Orders,
    Goods
  }
};
</script>
<style scoped>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);
</style>