import {Component, Inject} from "@angular/core";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {PersonService} from "../../service/person/person.service";
import {Person} from "../../model/person/person";
import {TabService} from "../../service/tab/tab.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'delete-person-dialog',
  templateUrl: '../../view/dialog/delete-person-dialog.component.html',
})
export class DeletePersonDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: {id: string},
              private personService: PersonService,
              private tabService: TabService,
              private _snackBar: MatSnackBar) {
  }

  deletePerson() {
    this.personService.deletePersonById(this.data.id).subscribe(
      (data: any) => {
        this.tabService.removeOpenedTab();
        return data;
    },
      error => {
        let data = error.error;
        this._snackBar.open(data.message, 'Закрыть');
      }
    );
  }
}
