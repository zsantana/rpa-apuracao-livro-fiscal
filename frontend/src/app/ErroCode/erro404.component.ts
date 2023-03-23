import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

@Component({
    selector: 'app-erro-404',
    templateUrl: './erro404.component.html',
    styleUrls: ['./erro404.component.scss']
})
export class Erro404Component implements OnInit {
    constructor(
        private _location: Location
    ) {
    }

    ngOnInit(): void {
    }
    backClicked() {
        this._location.back();
    }
}
