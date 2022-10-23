<template>
  <div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
      <div class="col-md-3 border-right">
        <div class="d-flex flex-column align-items-center text-center p-3 py-5"><span class="font-weight-bold"> Current</span><img v-bind:src="store.user.imageUrl" alt="avatar" class="rounded-circle img-fluid" style="width: 150px;">
            <div class="input-group">
            <div class="input-group-prepend">
<!--              <span  @click="RestoreUserAvatar" :disabled=!store.isLoaded class="input-group-text" id="inputGroupFileAddon01" href="#" ><img src="http://localhost:3000/store/icons/trash_can_icon.png"  style="width:25px;" /></span>-->
            </div>
            <div class="custom-file">
              <input  ref="file" v-on:change="handleFileUpload()" type="file" accept=".jpg, .jpeg, .png, .bmp"  class="custom-file-input" id="inputGroupFile01" name="inputGroupFile01"
                     aria-describedby="inputGroupFileAddon01">
              <label class="custom-file-label" for="inputGroupFile01"></label>

            </div>
          </div>
        </div>
      </div>
      <div class="col-md-5 border-right">
        <div class="p-3 py-5">
          <div class="d-flex justify-content-between align-items-center mb-3">
            <h4 class="text-right">Profile Settings</h4>
          </div>
          <div class="row mt-3">
            <div class="col-md-12"><label class="labels">Full name</label><input type="text" class="form-control" placeholder="Full name" v-model="UserFullName"></div>
            <div class="col-md-12"><label class="labels">Description</label><textarea type="text" v-model="UserDescription" placeholder="Description" style="resize: none; height: 150px; margin-bottom: 7px;" maxlength="250" id="form10" class="md-textarea form-control" rows="3"></textarea></div>
          </div>
          <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button" @click="saveUser" >Save Profile</button></div>
        </div>
      </div>
      <div class="col-md-4">
        <div class="p-3 py-5">
          <div class="d-flex justify-content-between align-items-center experience"><span>Edit Policy</span><button class="btn btn-primary profile-button" type="button"  @click="UpdatePolicyUser">Save Policy</button></div><br>
          <div class="col-md-12"><label class="labels">Password</label><input type="text" class="form-control" placeholder="Password" v-model="UserPassword"></div> <br>
          <div class="col-md-12"><label class="labels">Password Confirm</label><input v-model="UserPasswordConfirm" type="text" class="form-control" placeholder="Password Confirm"></div> <br>
<!--          <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control" placeholder="Email" v-model="UserEmail"></div>-->
        </div>
      </div>
    </div>
      <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button" @click="DeleteUser" >Delete User</button></div>
  </div>
</template>

<script>
import {ref} from "vue";
import {useUserStore} from "../../stores/user";
import {useAuthStore} from "../../stores/auth";
export default {
  name: 'User-Redact-Profile',
  setup () {
    const store = useUserStore()

      const UserFullName = ref()
      const UserDescription = ref()
      const UserPassword = ref()
      const UserPasswordConfirm = ref()
      const file = ref(null)
//, input.files[0]
      const saveUser = function () {
          console.log('saving User: ')
              store.tryUpdateUser(UserFullName.value, UserDescription.value)

      }

      const handleFileUpload = async() => {
          // debugger;
          console.log("selected file",file.value.files)
          //Upload to server
          store.UpdateAvatar(file.value.files[0])
      }
    
      const DeleteUser = function() {
          const authStore = useAuthStore()
          authStore.DeleteUser()
      }

      const UpdatePolicyUser = function () {
          console.log('Start Updating Policy: ')
          store.apiTryUpdatePolicyUser(UserPassword.value, UserPasswordConfirm.value)
      }
    return {
        store, UserFullName, UserDescription, UserPassword, UserPasswordConfirm, saveUser, UpdatePolicyUser, handleFileUpload, file, DeleteUser
    }
  }
}
</script>

<style scoped>
body {
  background: rgb(99, 39, 120)
}

.form-control:focus {
  box-shadow: none;
  border-color: #BA68C8
}

.profile-button {
  background: rgb(99, 39, 120);
  box-shadow: none;
  border: none
}

.profile-button:hover {
  background: #682773
}

.profile-button:focus {
  background: #682773;
  box-shadow: none
}

.profile-button:active {
  background: #682773;
  box-shadow: none
}

.back:hover {
  color: #682773;
  cursor: pointer
}

.labels {
  font-size: 11px
}

.add-experience:hover {
  background: #BA68C8;
  color: #fff;
  cursor: pointer;
  border: solid 1px #BA68C8
}
</style>
