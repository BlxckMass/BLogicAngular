import {Component} from "@angular/core";
import {TabService} from "../../service/tab/tab.service";
import {Incoming} from "../../model/document/incoming";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'document',
  templateUrl: '../../view/document/view-document.component.html'
})
export class ViewDocumentComponent {

  // @ts-ignore
  incoming: Incoming;
  type: string;

  constructor(private tabService: TabService,
              private http: HttpClient) {
    this.type = this.tabService.getTab().type;
  }

  ngOnInit() {
    console.log(this.type)
    this.http.get('http://localhost:8080/getDoc/' + this.tabService.id).subscribe((data: any) => {
      console.log(data);
      this.incoming = new Incoming(data.incoming.id, data.incoming.name, data.incoming.text, data.incoming.registrationNumber, data.incoming.dateOfRegistration,
        data.incoming.author, data.incoming.sender, data.incoming.addressee, data.incoming.outgoingNumber, data.incoming.outgoingDateOfRegistration);
    });
  }

  deleteDocument() {

  }

  closeTab() {
    this.tabService.removeOpenedTab();
  }
}
