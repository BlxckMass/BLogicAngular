import {Component, Inject} from "@angular/core";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {TabService} from "../../service/tab/tab.service";
import {IncomingDocumentService} from "../../service/document/incoming-document.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'delete-person-dialog',
  templateUrl: '../../view/dialog/delete-document-dialog.component.html',
})
export class DeleteIncomingDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: { id: string },
              private _snackBar: MatSnackBar,
              private incomingService: IncomingDocumentService,
              private tabService: TabService) {
  }

  deleteDocument() {
    this.incomingService.deleteIncomingById(this.data.id).subscribe(
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
