import {Component, Inject} from "@angular/core";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {TabService} from "../../service/tab/tab.service";
import {OutgoingDocumentService} from "../../service/document/outgoing-document.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'delete-person-dialog',
  templateUrl: '../../view/dialog/delete-document-dialog.component.html',
})
export class DeleteOutgoingDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: {id: string},
              private _snackBar: MatSnackBar,
              private outgoingService: OutgoingDocumentService,
              private tabService: TabService) {
  }

  deleteDocument() {
    this.outgoingService.deleteOutgoingById(this.data.id).subscribe(
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
