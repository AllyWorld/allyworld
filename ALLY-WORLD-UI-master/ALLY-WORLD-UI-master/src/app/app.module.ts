import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'
import { HttpClient } from '@angular/common/http';

import {HomeComponent} from './home/home.component';
import {RegisterComponent} from './register/register.component';
import {HeaderComponent} from './header/header.component';

import { AppComponent  } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { MaincontentComponent } from './maincontent/maincontent.component';
import { NewsFeedComponent } from './news-feed/news-feed.component';
import { RightsidebarComponent } from './rightsidebar/rightsidebar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ProfileViewComponent } from './profile-view/profile-view.component';

import { Routes, RouterModule } from '@angular/router';
import { ProfileFeedComponent } from './profile-feed/profile-feed.component';
import { ProfileLiftSideBarComponent } from './profile-lift-side-bar/profile-lift-side-bar.component';
import { ProfileRightSideBarComponent } from './profile-right-side-bar/profile-right-side-bar.component';
import { ProfileCreatePostComponent } from './profile-create-post/profile-create-post.component';
import { ProfileMainContentComponent } from './profile-main-content/profile-main-content.component';
import { UploadImageComponent } from './upload-image/upload-image.component';
import { LinkComponent } from './link/link.component';
const routes: Routes = [
{path:'navbar', component:NavbarComponent},
{path: 'create-post',component: CreatePostComponent},
{path: 'maincontent',component: MaincontentComponent},
{path: 'news-feed',component: NewsFeedComponent},
{path: 'rightsidebar',component: RightsidebarComponent},
{path: 'sidebar',component: SidebarComponent},
{path: 'profile-view',component: ProfileViewComponent},
 {path:'home', component:HomeComponent},
  {path: 'register',component: RegisterComponent},
  {path: 'header',component: HeaderComponent},
  {path: '',component: HomeComponent},
  {path:"link",component:LinkComponent}

]
 

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CreatePostComponent,
    MaincontentComponent,
    NewsFeedComponent,
    RightsidebarComponent,
    SidebarComponent,
    ProfileViewComponent,
    ProfileFeedComponent,
    ProfileLiftSideBarComponent,
    ProfileRightSideBarComponent,
    ProfileCreatePostComponent,
    ProfileMainContentComponent,
    UploadImageComponent,
    HomeComponent,
    HeaderComponent,
    RegisterComponent,
    LinkComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
