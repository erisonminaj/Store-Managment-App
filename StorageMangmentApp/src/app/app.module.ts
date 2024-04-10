import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./user/user.service";
import {FormsModule} from "@angular/forms";
import {ProductComponent} from "./product/productComponent";
import {RouterModule} from "@angular/router";
import {routes} from "./app.routes";
import {UserComponent} from "./user/user.component";

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    UserComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        [RouterModule.forRoot(routes)]
    ],
  providers: [UserService],
  bootstrap: [AppComponent],
  exports: [RouterModule]

})

export class AppModule { }
