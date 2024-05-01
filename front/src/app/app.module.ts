import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OffreComponent } from './offre/offre.component';
import { FormsModule } from '@angular/forms';
import { SidebarComponent } from './sidebar/sidebar.component';
import { SessionComponent } from './session/session.component';
import { AddsessionComponent } from './session/addsession/addsession.component';
import { UpdatesessionComponent } from './session/updatesession/updatesession.component';
import { CommonModule, DatePipe } from '@angular/common';
import { CalendarComponent } from './calendar/calendar.component';
import { MaterielComponent } from './materiel/materiel.component';
import { AddmaterielComponent } from './materiel/addmateriel/addmateriel.component';
import { UpdatematerielComponent } from './materiel/updatemateriel/updatemateriel.component';
import { StudygComponent } from './studyg/studyg.component';
import { AddStudygComponent } from './studyg/add-studyg/add-studyg.component';
import { UpdateStudygComponent } from './studyg/update-studyg/update-studyg.component';
import { OussamaComponent } from './oussama/oussama.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ToastrModule } from 'ngx-toastr';
import { AllTemplateFrontComponent } from './all-template-front/all-template-front.component';
import { HeaderComponent } from './header/header.component';
import { DynamicComponent } from './dynamic/dynamic.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    OffreComponent,
    SidebarComponent,
    SessionComponent,
    AddsessionComponent,
    UpdatesessionComponent,
    CalendarComponent,
    MaterielComponent,
    AddmaterielComponent,
    UpdatematerielComponent,
    StudygComponent,
    AddStudygComponent,
    UpdateStudygComponent,
    OussamaComponent,
    NavbarComponent,
    AllTemplateFrontComponent,
    HeaderComponent,
    DynamicComponent,
    FooterComponent,
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule, 
    FormsModule ,
    CommonModule,
    AppRoutingModule,
    ToastrModule.forRoot({
      positionClass: 'toast-top-right',
      timeOut: 5000, 
      closeButton: true, 
      progressBar: true, 
      progressAnimation: 'increasing',
      preventDuplicates: true, 
      maxOpened: 1, 
      autoDismiss: true, 
      newestOnTop: true, 
      enableHtml: true, 
      tapToDismiss: true, 
      toastClass: 'ngx-toastr', 
      iconClasses: {
        error: 'toast-error', 
        info: 'toast-info', 
        success: 'toast-success', 
        warning: 'toast-warning', 
      }
    })
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
