import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileLiftSideBarComponent } from './profile-lift-side-bar.component';

describe('ProfileLiftSideBarComponent', () => {
  let component: ProfileLiftSideBarComponent;
  let fixture: ComponentFixture<ProfileLiftSideBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileLiftSideBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileLiftSideBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
