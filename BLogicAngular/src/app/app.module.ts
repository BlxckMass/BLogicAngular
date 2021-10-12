import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTabsModule} from "@angular/material/tabs";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatTreeModule} from '@angular/material/tree';
import {UpdatePersonComponent} from "./component/person/update-person.component";
import {MatIconModule} from "@angular/material/icon";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {TabComponent} from "./component/tab/tab.component";
import {TabService} from "./service/tab/tab.service";
import {HttpClientModule} from "@angular/common/http";
import {PersonService} from "./service/person/person.service";
import {MatSelectModule} from "@angular/material/select";
import {MatOptionModule} from "@angular/material/core";
import {PersonTableComponent} from "./component/person/person-table.component";
import {MatTableModule} from "@angular/material/table";
import {TreeService} from "./service/tree/tree.service";
import {DynamicDatabaseService} from "./service/dynamic-database/dynamic-database.service";
import {TreeComponent} from "./component/tree/tree.component";
import {DeletePersonDialogComponent} from "./component/dialog/delete-person-dialog.component";
import {MatDialogModule} from "@angular/material/dialog";
import {DialogService} from "./service/dialog/dialog.service";
import {PersonTableService} from "./service/person/person-table.service";
import {ViewDocumentComponent} from "./component/document/view-document.component";
import {IncomingDocumentComponent} from "./component/document/incoming-document.component";
import {TaskDocumentComponent} from "./component/document/task-document.component";
import {OutgoingDocumentComponent} from "./component/document/outgoing-document.component";
import {TaskDocumentService} from "./service/document/task-document.service";
import {OutgoingDocumentService} from "./service/document/outgoing-document.service";
import {IncomingDocumentService} from "./service/document/incoming-document.service";
import {DeleteTaskDialogComponent} from "./component/dialog/delete-task-dialog.component";
import {DeleteOutgoingDialogComponent} from "./component/dialog/delete-outgoing-dialog.component";
import {DeleteIncomingDialogComponent} from "./component/dialog/delete-incoming-dialog.component";
import {DocumentService} from "./service/document/document.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AddPersonComponent} from "./component/person/add-person.component";
// import {RouterModule, Routes} from "@angular/router";

// const appRoutes: Routes = [
//   {path: "/person/edit", component: UpdatePersonComponent}
// ]

@NgModule({
  declarations: [
    AppComponent,
    TabComponent,
    AddPersonComponent,
    UpdatePersonComponent,
    TreeComponent,
    PersonTableComponent,
    ViewDocumentComponent,
    IncomingDocumentComponent,
    OutgoingDocumentComponent,
    TaskDocumentComponent,
    DeletePersonDialogComponent,
    DeleteTaskDialogComponent,
    DeleteOutgoingDialogComponent,
    DeleteIncomingDialogComponent
  ],
  imports: [
    BrowserModule,
    // RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    HttpClientModule,
    MatTabsModule,
    MatFormFieldModule,
    MatCheckboxModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatTreeModule,
    MatIconModule,
    MatProgressBarModule,
    FormsModule,
    MatSelectModule,
    MatOptionModule,
    MatTableModule,
    MatDialogModule
  ],
  providers: [
    TabService,
    PersonService,
    TreeService,
    DynamicDatabaseService,
    DialogService,
    PersonTableService,
    DocumentService,
    TaskDocumentService,
    OutgoingDocumentService,
    IncomingDocumentService,
    MatSnackBar
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
