import {Component} from "@angular/core";
import {Incoming} from "../../model/document/incoming";
import {TabService} from "../../service/tab/tab.service";
import {HttpClient} from "@angular/common/http";
import {DialogService} from "../../service/dialog/dialog.service";
import {TreeService} from "../../service/tree/tree.service";
import {DynamicDatabaseService} from "../../service/dynamic-database/dynamic-database.service";
import {IncomingDocumentService} from "../../service/document/incoming-document.service";

@Component({
  selector: 'incoming-document',
  templateUrl: '../../view/document/incoming-document.component.html'
})
export class IncomingDocumentComponent {

  // @ts-ignore
  incoming: Incoming;

  constructor(private incomingService: IncomingDocumentService,
              private tabService: TabService,
              private dialogService: DialogService,
              private treeService: TreeService,
              private dynamicDatabase: DynamicDatabaseService,
              private http: HttpClient) {
  }

  ngOnInit() {
    this.incomingService.getIncomingById(this.tabService.id).subscribe((data: Incoming) => {
      this.incoming = data;
      console.log(this.incoming)
    })
  }

  deleteDocument() {
    this.dialogService.openDeleteIncomingDialog(this.incoming.id);
    this.treeService.dataSource.data = this.dynamicDatabase.initialData();
  }

  closeTab() {
    this.tabService.removeOpenedTab();
  }
}
