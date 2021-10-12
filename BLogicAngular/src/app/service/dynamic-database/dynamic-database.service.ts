import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {DynamicFlatNode} from "../../model/dynamic-database/dynamic-flat-node";
import {PersonService} from "../person/person.service";
import {DocumentService} from "../document/document.service";
import {Person} from "../../model/person/person";
import {Document} from "../../model/document/document";

@Injectable()
export class DynamicDatabaseService {

  constructor(private personService: PersonService,
              private documentService: DocumentService,
              private http: HttpClient) {
  }

  dataMap = new Map<string, any[][]>([
    ['Сотрудники', []],
    ['Документы', []]
  ]);

  rootLevelNodes: string[] = ['Сотрудники', 'Документы'];

  initialData(): DynamicFlatNode[] {
    this.refreshNode();
    return this.rootLevelNodes.map(name => new DynamicFlatNode(0, name, name, 0, true));
  }

  refreshNode() {
    // this.http.get<string[]>("http://localhost:8080/").subscribe((data: any) => this.dataMap.set('Сотрудники', data));
    // this.http.get<string[]>("http://localhost:8080/test2").subscribe((data: any[]) => this.dataMap.set('Документы', data));
    this.personService.getAllPersons().subscribe((data: any[]) => {
      this.dataMap.set('Сотрудники', data);
    });
    this.documentService.getAllDocuments().subscribe((data: any[]) => {
      this.dataMap.set('Документы', data);
    });
  }

  getChildren(node: any): any[] | undefined {
    return this.dataMap.get(node);
  }

  isExpandable(node: string): boolean {
    return this.dataMap.has(node);
  }
}
